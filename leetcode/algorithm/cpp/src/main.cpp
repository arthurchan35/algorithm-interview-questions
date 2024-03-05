#include "Solution.h"

#include <iostream>

int main() {
	std::cout << "Hello, World!";

	encode_decode_string::Solution sol1;

	contain_duplicate::Solution sol2;

	std::vector<std::string> original = {"Strings with spaces are tricky","Another one with spaces","This also has spaces", "EmojiTest 😊"};

	auto encoded = sol1.encode(original);
	auto decoded = sol1.decode(encoded);
	std::cout << "decoded vector size: " << decoded.size() << std::endl;

	for (auto str : sol1.decode(encoded)) {
		std::cout << "delimit|" << str << "|delimit" << std::endl;
	}

	return 0;
}