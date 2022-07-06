# @param {Integer[][]} grid
# @return {Integer}
$DIRECTIONS = [[1, 0], [-1, 0], [0, 1], [0, -1]]

def on_perimeter(grid, r, c)
   [0, grid.length - 1].include?(r) || [0, grid[0].length - 1].include?(c) 
end

def out_of_bounds(grid, r, c)
   [-1, grid.length].include?(r) || [-1, grid[0].length].include?(c)  
end

def dfs(grid, r, c, visit)
    return if out_of_bounds(grid, r, c) || visit.include?([r, c]) || grid[r][c] == 1
    visit << [r, c]
    $DIRECTIONS.each { |dr, dc| dfs(grid, r + dr, c + dc, visit) }
end

def each_row_and_column(grid)
    (0...grid.length).each do |r|
        (0...grid[0].length).each do |c|
            yield(r, c)
        end
    end
end

def closed_island(grid)
    visit = Set.new
    
    # visit islands touching perimeter
    each_row_and_column(grid) do |r, c|
        unless !on_perimeter(grid, r, c) || visit.include?([r, c]) || grid[r][c] == 1
            dfs(grid, r, c, visit)
        end
    end
    
    # count remaining unvisited islands
    closed_islands = 0
    each_row_and_column(grid) do |r, c|
        unless visit.include?([r, c]) || grid[r][c] == 1
            dfs(grid, r, c, visit)
            closed_islands += 1
        end
    end
    
    closed_islands
end