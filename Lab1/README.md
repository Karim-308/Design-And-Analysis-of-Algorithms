# Generating Magic Squares

This C++ program generates all permutations of numbers 1 to 9 to form a 3x3 magic square. A magic square is a square matrix where the sum of each row, column, and diagonal is the same.

## Prerequisites

To run this program, you need a C++ compiler installed on your system.

## How to Run

1. Open a terminal or command prompt.
2. Navigate to the directory containing the source code file (`magic_square.cpp`).
3. Compile the code using a C++ compiler. For example:
```
g++ magic_square.cpp -o magic_square
```
4. Run the compiled executable:


## Code Overview

### `printMagicSquare`

- This function prints the generated magic square along with the current way number.
- It takes a vector `square` representing the magic square as input.

### `isMagicSquare`

- This function checks whether a given square forms a magic square.
- It calculates the magic sum (sum of each row, column, and diagonal) and verifies if all sums are equal.
- It takes a vector `square` representing the magic square as input and returns true if it's a magic square, false otherwise.

### `permutation`

- This function recursively generates all permutations of numbers 1 to 9 to form a magic square.
- It backtracks when a permutation is complete or when it's determined that a permutation cannot form a magic square.
- It takes vectors `nums`, `square`, and `used`, along with an index `index` indicating the current state of the permutation, as input.

### `main`

- The `main` function initializes vectors `nums`, `square`, and `used`.
- It calls the `permutation` function to generate permutations and form magic squares.

## Example Output
```
Way 1:
2 7 6
9 5 1
4 3 8

Way 2:
2 9 4
7 5 3
6 1 8
.
.
.
```

