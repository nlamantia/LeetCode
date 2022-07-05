# @param {String} s
# @return {Boolean}
def is_valid(s)
    stack = []
    closing_brackets = {
        ')' => '(',
        '}' => '{',
        ']' => '['
    }
    
    s.split('').each do |c|
        if closing_brackets.key?(c) && !stack.empty? && closing_brackets[c] == stack[0]
            stack.shift
        else
            stack.unshift(c)
        end
    end
    
    stack.empty?
end