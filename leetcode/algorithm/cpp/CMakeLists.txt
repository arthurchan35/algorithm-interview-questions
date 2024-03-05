# Specify the minimum version for CMake
cmake_minimum_required(VERSION 3.10)

# Project's name
project(algr_interview_questions)

# Set the C++ standard
set(CMAKE_CXX_STANDARD 23)

# add the include directory to the include path
include_directories(include)

# add the source files
add_executable(
	algr_interview_questions
	src/main.cpp
	src/contain_duplicate/Solution.cpp
	src/encode_decode_string/Solution.cpp
)

# If you have any libraries to link
# target_link_libraries(algr_interview_questions my_library)