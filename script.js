document.addEventListener('DOMContentLoaded', function() {
    // Initialize code highlighting
    hljs.highlightAll();
    
    // Tab switching functionality for code snippets
    const tabBtns = document.querySelectorAll('.tab-btn');
    const tabContents = document.querySelectorAll('.tab-content');
    
    tabBtns.forEach(btn => {
        btn.addEventListener('click', () => {
            const tabId = btn.getAttribute('data-tab');
            
            // Remove active class from all buttons and tabs
            tabBtns.forEach(b => b.classList.remove('active'));
            tabContents.forEach(c => c.classList.remove('active'));
            
            // Add active class to current button and tab
            btn.classList.add('active');
            document.getElementById(`${tabId}-tab`).classList.add('active');
        });
    });
    
    // Caesar Cipher implementation for demo
    function caesarCipherEncrypt(text, shift) {
        if (shift < 0) {
            shift = shift % 26 + 26;
        }
        
        return text.split('').map(char => {
            if (char.match(/[a-z]/i)) {
                const code = char.charCodeAt(0);
                const isUpperCase = char === char.toUpperCase();
                const offset = isUpperCase ? 65 : 97;
                
                return String.fromCharCode((code - offset + shift) % 26 + offset);
            }
            return char;
        }).join('');
    }
    
    function caesarCipherDecrypt(text, shift) {
        return caesarCipherEncrypt(text, 26 - (shift % 26));
    }
    
    // Handle encryption button click
    document.getElementById('encrypt-btn').addEventListener('click', () => {
        const plaintext = document.getElementById('plaintext').value;
        const shift = parseInt(document.getElementById('shift-key').value, 10);
        
        if (plaintext.trim() === '') {
            alert('Please enter text to encrypt');
            return;
        }
        
        if (isNaN(shift) || shift < 1 || shift > 25) {
            alert('Please enter a valid shift key (1-25)');
            return;
        }
        
        const ciphertext = caesarCipherEncrypt(plaintext, shift);
        document.getElementById('ciphertext').value = ciphertext;
    });
    
    // Handle decryption button click
    document.getElementById('decrypt-btn').addEventListener('click', () => {
        const ciphertext = document.getElementById('ciphertext').value;
        const shift = parseInt(document.getElementById('shift-key').value, 10);
        
        if (ciphertext.trim() === '') {
            alert('Please enter text to decrypt');
            return;
        }
        
        if (isNaN(shift) || shift < 1 || shift > 25) {
            alert('Please enter a valid shift key (1-25)');
            return;
        }
        
        const plaintext = caesarCipherDecrypt(ciphertext, shift);
        document.getElementById('plaintext').value = plaintext;
    });
    
    // Brute force decryption
    document.getElementById('brute-force-btn').addEventListener('click', () => {
        const ciphertext = document.getElementById('ciphertext').value;
        
        if (ciphertext.trim() === '') {
            alert('Please enter text to decrypt using brute force');
            return;
        }
        
        const resultsContainer = document.getElementById('results-container');
        resultsContainer.innerHTML = '';
        
        // Try all 25 possible shifts
        for (let i = 1; i <= 25; i++) {
            const decrypted = caesarCipherDecrypt(ciphertext, i);
            
            const resultItem = document.createElement('div');
            resultItem.className = 'result-item';
            resultItem.innerHTML = `
                <p>Shift ${i}:</p>
                <div class="result-text">${decrypted}</div>
            `;
            
            resultsContainer.appendChild(resultItem);
        }
        
        // Show the results section
        document.getElementById('brute-force-results').style.display = 'block';
    });
    
    // Smooth scroll for navigation links
    document.querySelectorAll('a[href^="#"]').forEach(anchor => {
        anchor.addEventListener('click', function(e) {
            e.preventDefault();
            
            const targetId = this.getAttribute('href');
            const targetElement = document.querySelector(targetId);
            
            if (targetElement) {
                window.scrollTo({
                    top: targetElement.offsetTop - 70, // Adjust for fixed header
                    behavior: 'smooth'
                });
            }
        });
    });
}); 