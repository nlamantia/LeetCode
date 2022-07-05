# @param {Integer[][]} image
# @param {Integer} sr
# @param {Integer} sc
# @param {Integer} color
# @return {Integer[][]}
def out_of_bounds(image, r, c)
    row_bounds = [-1, image.length]
    col_bounds = [-1, image[0].length]
    return true if row_bounds.include?(r) || col_bounds.include?(c)
    false
end

def dfs(image, r, c, old_color, new_color, visit)
    return if out_of_bounds(image, r, c) || image[r][c] != old_color || visit.include?([r, c])
    visit << [r, c]
    image[r][c] = new_color
    
    [[1, 0], [-1, 0], [0, 1], [0, -1]].each do |dr, dc|
         dfs(image, r + dr, c + dc, old_color, new_color, visit)
    end
end

def flood_fill(image, sr, sc, color)
    visit = Set.new
    dfs(image, sr, sc, image[sr][sc], color, visit)
    image
end