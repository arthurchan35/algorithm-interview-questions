#include <vector>
#include <string>

#ifndef CONTAIN_DUPLICATE
#define CONTAIN_DUPLICATE

namespace contain_duplicate {
	class Solution {
	public:
		bool containsDuplicate(std::vector<int>& nums);
	};
}

#endif



#ifndef ENCODE_DECODE_STRING
#define ENCODE_DECODE_STRING

namespace encode_decode_string {

	class Solution {
	public:

		std::string encode(std::vector<std::string>& strs);

		std::vector<std::string> decode(std::string s);
	};
}

#endif