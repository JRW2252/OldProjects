cmake_minimum_required(VERSION 3.2)
project(morse_code)

set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++11")

set(SOURCE_FILES main.cpp)
add_executable(morse_code ${SOURCE_FILES})