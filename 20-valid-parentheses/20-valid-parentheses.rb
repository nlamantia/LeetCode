# @param {String} s
# @return {Boolean}
def is_valid(s)
    stack = []
    closing_brackets = {
        ')' => '(',
        '}' => '{',
        ']' => '['
    }
    
    (0...s.length).each do |i|
        c = s[i]
        if closing_brackets.key?(c) && !stack.empty? && closing_brackets[c] == stack[0]
            stack.shift
        else
            stack.unshift(c)
        end
    end
    
    stack.empty?
end