cmake_minimum_required(VERSION 3.2)
project(morse_codes)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp)
add_executable(morse_codes ${SOURCE_FILES} morse_tree.h morse_tree.cpp)