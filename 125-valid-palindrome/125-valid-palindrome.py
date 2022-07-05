class Solution:
    def isPalindrome(self, s: str) -> bool:
        s = re.sub(r'[^a-z0-9]', '', s.lower())
        start, end = 0, len(s) - 1
        while start < end:
            if s[start] != s[end]:
                return False
            start += 1
            end -= 1

        return True
        