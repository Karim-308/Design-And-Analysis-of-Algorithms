#include <iostream>
#include <vector>

using namespace std;

const int SIZE = 3; // Size of the magic square (3x3)

int ways = 1; // Global variable to track the number of ways

/**
 * @brief Prints the magic square along with the current way number.
 * 
 * @param square The magic square to be printed.
 */
void printMagicSquare(const vector<int>& square) {
    cout << "Way " << ways++ << ":" << endl; // Print the way number and increment
    for (int i = 0; i < SIZE; ++i) {
        for (int j = 0; j < SIZE; ++j) {
            cout << square[i * SIZE + j] << " "; // Print each element of the square
        }
        cout << endl;
    }
    cout << endl;
}

/**
 * @brief Checks if a given square forms a magic square.
 * 
 * A magic square is a square matrix where the sum of each row, column, and diagonal is the same.
 * 
 * @param square The square to be checked.
 * @return true if the square is a magic square, false otherwise.
 */
bool isMagicSquare(const vector<int>& square) {
    const int SIZE = 3;

    // Define the magic sum (sum of each row, column, and diagonal)
    int magicSum = square[0] + square[1] + square[2];

    // Check rows and columns
    for (int i = 0; i < SIZE; ++i) {
        int rowSum = 0;
        int colSum = 0;
        for (int j = 0; j < SIZE; ++j) {
            rowSum += square[i * SIZE + j];
            colSum += square[j * SIZE + i];
        }
        if (rowSum != magicSum || colSum != magicSum) return false;
    }

    // Check main diagonal and anti-diagonal
    int diagonalSum = 0;
    int antiDiagonalSum = 0;
    for (int i = 0; i < SIZE; ++i) {
        diagonalSum += square[i * SIZE + i];
        antiDiagonalSum += square[i * SIZE + (SIZE - 1 - i)];
    }
    if (diagonalSum != magicSum || antiDiagonalSum != magicSum) return false;

    return true;
}

/**
 * @brief Generates all permutations of numbers to form a magic square.
 * 
 * This function recursively generates all permutations of numbers 1 to 9 to form a 3x3 magic square.
 * It checks each permutation and prints the magic squares.
 * 
 * @param nums The vector containing numbers 1 to 9.
 * @param square The vector representing the 3x3 grid of the magic square.
 * @param used A vector indicating whether a number has been used in the permutation.
 * @param index The current index in the permutation process.
 */
void permutation(vector<int>& nums, vector<int>& square, vector<bool>& used, int index) {
    if (index == SIZE * SIZE) { // If all cells are filled
        if (isMagicSquare(square)) { // Check if the square is a magic square
            printMagicSquare(square); // Print the magic square with the current way number
        }
        return;
    }

    for (int i = 0; i < nums.size(); ++i) {
        if (!used[i]) { // If the number is not used in the current permutation
            square[index] = nums[i]; // Place the number in the current cell
            used[i] = true; // Mark the number as used
            permutation(nums, square, used, index + 1); // Recursively generate permutations for the next cell
            used[i] = false; // Backtrack: Mark the number as unused
        }
    }
}

int main() {
    vector<int> nums = {1, 2, 3, 4, 5, 6, 7, 8, 9}; // Numbers 1 to 9
    vector<int> square(SIZE * SIZE); // Vector to represent the 3x3 grid of the magic square
    vector<bool> used(nums.size(), false); // Vector to indicate whether a number has been used in the permutation

    permutation(nums, square, used, 0); // Generate permutations to form magic squares

    return 0;
}
