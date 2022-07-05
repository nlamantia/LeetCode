class Solution:
    def romanToInt(self, s: str) -> int:
        res = 0
        i = 0
        subtract_digits = {
            'I': set(['V', 'X']),
            'X': set(['L', 'C']),
            'C': set(['D', 'M'])
        }
        
        values = {
            'I': 1,
            'V': 5,
            'X': 10,
            'L': 50,
            'C': 100,
            'D': 500,
            'M': 1000,
        }
        
        while i < len(s):
            c1 = s[i]
            c2 = s[i + 1] if i < len(s) - 1 else None
            if c1 in subtract_digits and c2 in subtract_digits[c1]:
                res += values[c2] - values[c1]
                i += 1
            else:
                res += values[c1]
            i += 1
            
        return res