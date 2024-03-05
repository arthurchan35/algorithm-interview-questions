#include "Solution.h"

#include <vector>
#include <string>

using namespace std;

namespace encode_decode_string {

	string Solution::encode(vector<string>& strs) {

		string result;

		result.reserve(strs.size() * 128);

		for (string str: strs) {

			// the problem has guarenteed the size of a string will not exceed 200
			char charStorageOfStrSize = (char) str.length();

			result.push_back(charStorageOfStrSize);

			result.append(str);
		}

		return result;
	}

	vector<string> Solution::decode(string s) {

		vector<string> result;
		result.reserve(s.length());

		uint16_t index = 0;

		while(index < s.length()) {
			char strSize = s[index];

			result.push_back(s.substr(index + 1, strSize));

			index += 1 + strSize;
		}


		return result;
	}
}