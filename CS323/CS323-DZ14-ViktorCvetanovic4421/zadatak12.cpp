#include <iostream>
#include <fstream>
#include <string>
#include <stack>

int main(int argc, char* argv[]) {
    if (argc != 2) {
        std::cerr << "Usage: " << argv[0] << " <filename.cpp>" << std::endl;
        return 1;
    }

    std::string filename = argv[1];
    std::ifstream file(filename);

    if (!file.is_open()) {
        std::cerr << "Error opening file: " << filename << std::endl;
        return 1;
    }

    std::string line;
    std::stack<char> brackets;

    while (std::getline(file, line)) {
        for (char c : line) {
            if (c == '(') {
                brackets.push(c);
            } else if (c == ')') {
                if (brackets.empty() || brackets.top() != '(') {
                    std::cout << "Unequal number of parentheses in the file." << std::endl;
                    return 0;
                }
                brackets.pop();
            }
        }
    }

    if (brackets.empty()) {
        std::cout << "Equal number of parentheses in the file." << std::endl;
    } else {
        std::cout << "Unequal number of parentheses in the file." << std::endl;
    }

    return 0;
}
