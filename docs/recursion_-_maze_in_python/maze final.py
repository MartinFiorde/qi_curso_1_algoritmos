import time
map = [["S"," ","#"," "," ","#","#"],
       ["#"," ","#"," "," ","#","#"],
       ["#"," ","#"," ","#","#","E"],
       ["#"," "," "," "," "," "," "],
       ["#","#","#","#","#","#","#"]
]

dir = [(-1,0),(0,1),(1,0),(0,-1)]

def print_map(map):
    for row in map:
        print(" ".join(row))
    print("")
    
def walk (map, x, y, path):
    time.sleep(0.1) 
    # 1. BASE CASES
    if x < 0 or x >= len(map) or y < 0 or y >= len(map[0]): # 1.1. OUT OF BOUND
        return False
    if map[x][y] == "#": # 1.2. HIT WALL
        return False
    if map[x][y] == "-" or map[x][y] == "x" : # 1.3. ALREADY BEEN THERE
        return False
    if map[x][y] == "E": # 1.4. FIND EXIT
        # 1.4.1 PRE SUCCESS BASE CASE
        map[x][y] = "-"
        path.append((x,y))
        print_map(map)
        return True

    # 2. RECURSE
    # 2.1. PRE RECURSE
    map[x][y] = "-"
    path.append((x,y))
    print_map(map)

    # 2.2. RECURSE PER SE
    for i in dir:
        if walk(map, x+i[0], y+i[1], path):
            return True

    # 2.3. POST RECURSE
    map[x][y] = "x"
    path.pop()
    print_map(map)
    return False
    
        
def solve(map):
    path = []
    print_map(map)
    walk(map,0, 0, path)
    print("Maze Solved!")
    print(path)


solve(map)
