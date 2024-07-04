map = [["#","#","#","#","#","#","#"],
       ["#","S","#","#","#","E","#"],
       ["#"," ","#"," ","#"," ","#"],
       ["#"," "," "," "," "," ","#"],
       ["#","#","#","#","#","#","#"]
]

dir = [(-1,0),(0,1),(1,0),(0,-1)]


# BASE CASES
# 1. OUT OF BOUND
# 2. HIT WALL
# 3. GO BACK
# 4. FIND EXIT
def print_map(map):
    for row in map:
        print("".join(row))
    print("")
    
def walk (map, x, y, finished):
    if x < 0 or x >= len(map) or y < 0 or y >= len(map[0]):
        return map, False
    if map[x][y] == "#":
        return map, False
    if map[x][y] == "-":
        return map, False
    if map[x][y] == "E":
        map[x][y] = "-"
        print_map(map)
        return map, True
    map[x][y] = "-"
    print_map(map)
    for i in dir:
        map, finished = walk(map, x+i[0], y+i[1], False)
        if finished:
            return map, True
    map[x][y] = "x"
    return map, False
    
        
def solve(map):
    print_map(map)
    walk(map,1,1, True)
    print("Maze Solved!")


solve(map)
