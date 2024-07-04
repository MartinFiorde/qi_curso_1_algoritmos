import time

maze_12 = [
"M MMMMMMMM M", 
"M M        M", 
"M M MMMMMMMM", 
"M M        M", 
"M MMMMM MM M", 
"M   M   MMMM", 
"M M M M  M M", 
"MMM M MM M M", 
"M M   M  M M", 
"M MMMMMMMM M", 
"M       M  M", 
"MMMMMMMMMMMM"
]

maze_7 = [
"M MMMMM",
"M     M",
"M M MMM",
"M MMM M",
"M      ",
"M M M M",
"MMMMMMM"
]

dir = [
(1,0),
(0,1),
(-1,0),
(0,-1)
]

start_7_12 = (0,1)
end_12 = (0,10)
end_7 = (4,6)

def solve(maze, start, end):
    path = []
    maze_mtx = make_maze_mtx(maze)
    if move(maze_mtx, start, end, path):
        print("success! found the exit")
    else:
        print("you died")
    print(path)
    return path
    
def print_maze(maze_mtx):
    for i in range(len(maze_mtx)):
        row = ""
        for j in range(len(maze_mtx[i])):
            row += " "+maze_mtx[i][j]+" "
        print(row)
    print("")
    
def move(maze,current,end,path):
    # presets
    time.sleep(0.2)
    x = current[0]
    y = current[1]
    
    # fail base cases
    if x < 0 or x >= len(maze) or y < 0 or y >= len(maze[0]):
        return False
    if maze[x][y] != " ":
        return False
    if maze[x][y] == "-":
        return False
        
    # pre recursion
    maze[x][y] = "-"
    path.append((x,y))
    print_maze(maze)
    
    # success base case
    if current == end:
        return True
        
    # recursion
    for i in dir:
        new_current = (x + i[0], y + i[1])
        if move(maze, new_current, end, path):
            return True
            
    # post recursion
    maze[x][y] = "x"
    path.pop()
    return go_back(maze,current,end,path)
    
    
def go_back(maze,current,end,path):
    x = current[0]
    y = current[1]
    for i in reversed(dir):
        new_current = (x + i[0], y + i[1])
        if maze[new_current[0]][new_current[1]] == "-":
            
            move(maze, new_current, end, path)

def make_maze_mtx(maze):
    maze_mtx = []
    for i in range(len(maze)):
        maze_mtx.append([])
        for j in range(len(maze[i])):
            maze_mtx[i].append(maze[i][j:j+1])
    print_maze(maze_mtx)
    return maze_mtx
    

solve(maze_7, start_7_12, end_7)