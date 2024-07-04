import time
import os

def clear_screen():
    os.system('cls' if os.name == 'nt' else 'clear')

def loadstart(map, n, start, posi, posj):
    clear_screen()
    count = 0
    for i in range(n):
        for j in range(n):
            map[i][j] = start[count]
            count += 1
    showmap(map, n, posi, posj)
    input("presione una tecla para iniciar el recorrido")

def showmap(map, n, posi, posj):
    print(f"posición [{posi},{posj}]")
    for i in range(n):
        for j in range(n):
            if map[i][j] == "M":
                print("[X]", end='')
            elif map[i][j] == "X":
                print(" x ", end='')
            elif map[i][j] == "C":
                print(" . ", end='')
            elif map[i][j] == "B":
                print("   ", end='')
            elif map[i][j] == "V":
                print(" v ", end='')
            elif map[i][j] == "S":
                print(" s ", end='')
            else:
                print("???", end='')
        print("")
    print("")

def move(map, n, posi, posj):
    time.sleep(0.2)
    # clear_screen()
    if map[posi][posj+1] == "V" or map[posi][posj-1] == "V" or map[posi+1][posj] == "V" or map[posi-1][posj] == "V":
        print("se llego a la meta. juego finalizado")
    else:
        if map[posi][posj+1] == "B":  # RIGHT
            map[posi][posj+1] = "C"
            posi = posi
            posj = posj+1
            showmap(map, n, posi, posj)
            move(map, n, posi, posj)
        elif map[posi-1][posj] == "B":  # UP
            map[posi-1][posj] = "C"
            posi = posi-1
            posj = posj
            showmap(map, n, posi, posj)
            move(map, n, posi, posj)
        elif map[posi+1][posj] == "B":  # DOWN
            map[posi+1][posj] = "C"
            posi = posi+1
            posj = posj
            showmap(map, n, posi, posj)
            move(map, n, posi, posj)
        elif map[posi][posj-1] == "B":  # LEFT
            map[posi][posj-1] = "C"
            posi = posi
            posj = posj-1
            showmap(map, n, posi, posj)
            move(map, n, posi, posj)
        else:
            goback(map, n, posi, posj)

def goback(map, n, posi, posj):
    # clear_screen()
    map[posi][posj] = "X"
    if map[posi][posj-1] == "C":  # LEFT
        posi = posi
        posj = posj-1
        showmap(map, n, posi, posj)
        move(map, n, posi, posj)
    elif map[posi+1][posj] == "C":  # DOWN
        posi = posi+1
        posj = posj
        showmap(map, n, posi, posj)
        move(map, n, posi, posj)
    elif map[posi-1][posj] == "C":  # UP
        posi = posi-1
        posj = posj
        showmap(map, n, posi, posj)
        move(map, n, posi, posj)
    elif map[posi][posj+1] == "C":  # RIGHT
        posi = posi
        posj = posj+1
        showmap(map, n, posi, posj)
        move(map, n, posi, posj)
    else:
        print("rompiste todo")

def main():
    n = 12 # 7 12 22
    # start = "MSMMMMMMMMMMMMMMMMMMMMMBMBBBBBBBBBBBBMBBBBBMMBMBMMMMMMMMMMBMBMMMBMMBMBBBBBBBBBBMBBBBBMBMMBMMMMMMMMBMMMMMMMMMBMMBBBMBBBBMBBBBBBBMBBBMMBMBMBMBBMBMMMMMBMMMMMMBMBMBMBBMBBBMBBBMBBBMMBMBBBMBBMBMBMBMBMBMBMMBMMMMMMMMBMMMMMBMBMBMMBMBMBBBMBBMBBBMBMBMBMMBMBMBMBMMMMBMBMBBBMBMMBMBMBMBMBBMBMMMMMMMBMMBBBMBMBMMBMBMBBBBBMBMMBMBMBMBMBBMBMBMMMBMBMMBMBBBMBMMBMBMBMBBBMBMMBMMMMMBBBBMBBBMBMMMBMMBMBBBMMMMBMBMBMBMBMBMMBMBMBMBBBBMBMBMBMBMBMMBMBMBMMMMMMBMBMBMBMBMMBBBMBBBBBBBBMBMBBBMBMMMMMMMMMMMMMMMMMMMMMVM"
    start = "MSMMMMMMMMVMMBMBBBBBBBBMMBMBMMMMMMMMMBMBBBBBBBBMMBMMMMMBMMBMMBBBMBBBMMBMMBMBMBMBBMBMMBMBMBMMBMBMMBMBBBMBBMBMMBMMMMMMMMBMMBBBBBBBMBBMMMMMMMMMMMMM"
    # start = "MSMMMMMMBBBBBMMBMBMMMMBMMMBMMBBBBBMMBMBMBMMMMVMMM"
    map = [['' for _ in range(n)] for _ in range(n)]
    posi = 1
    posj = 0
    loadstart(map, n, start, posi, posj)
    move(map, n, posi, posj)

if __name__ == "__main__":
    main()
