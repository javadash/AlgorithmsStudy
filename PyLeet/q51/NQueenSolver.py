

def n_queens_solver(n):
    Q = [0] * (n + 1)
    solve_n_queens(Q, 1, n)

def solve_n_queens(Q, k, n):
    if k == n + 1:
        print_solution(Q)
        return

    for j in range(1, n + 1):
        valid = True
        for i in range(1, k):
            if Q[i] == j or Q[i] == j + k - i or Q[i] == j - k + i:
                valid = False
                break
        if valid:
            Q[k] = j
            solve_n_queens(Q, k + 1, n)

def print_solution(Q):
    print(" ".join(str(Q[i]) for i in range(1, len(Q))))

n = 8  # Change this value to the desired board size
n_queens_solver(n)
