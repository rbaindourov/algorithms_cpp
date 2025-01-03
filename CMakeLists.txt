cmake_minimum_required(VERSION 3.10)
project(LevelOrderTraversal)

find_package(Boost REQUIRED)
include_directories(${Boost_INCLUDE_DIRS})

add_executable(LevelOrderTraversal /home/robert/Documents/projects/algorithms_cpp/levelOrderTraversal.cpp)
