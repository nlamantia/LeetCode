# @param {Integer[][]} grid
# @return {Integer}
$directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]

def out_of_bounds(grid, r, c)
     [-1, grid.length].include?(r) || [-1, grid[0].length].include?(c)
end

def stop_search?(grid, r, c, visit)
   out_of_bounds(grid, r, c) || visit.include?([r, c]) || grid[r][c] == 0 
end

def dfs(grid, r, c, visit)
    return 0 if stop_search?(grid, r, c, visit)
    
    visit << [r, c]
    $directions.reduce(1) do |area, (dr, dc)|
       area += dfs(grid, r + dr, c + dc, visit) 
    end
end

def max_area_of_island(grid)
    visit = Set.new
    max_area = 0
    (0...grid.length).each do |r|
        (0...grid[0].length).each do |c|
            unless visit.include?([r, c]) || grid[r][c] == 0
                area = dfs(grid, r, c, visit)
                max_area = area if area > max_area
            end
        end
    end
    max_area
end