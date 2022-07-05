# @param {Character[][]} grid
# @return {Integer}
def dfs(grid, r, c, visit)
    return if [-1, grid.length].include?(r) || [-1, grid[0].length].include?(c)
    return if visit.include?([r, c]) || grid[r][c] == '0'
    
    visit.add([r, c])
    [[1, 0], [-1, 0], [0, 1], [0, -1]].each do |dr, dc|
        dfs(grid, r + dr, c + dc, visit)
    end
end

def num_islands(grid)
    count = 0
    visit = Set.new
    (0...grid.length).each do |r|
       (0...grid[0].length).each do |c|
           if grid[r][c] == '1' && !visit.include?([r, c]) 
              count += 1
              dfs(grid, r, c, visit) 
           end
       end
    end
    count
end