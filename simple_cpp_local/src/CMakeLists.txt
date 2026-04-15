add_library(simple_cpp SHARED
wrapper.cpp 
hello.h 
hello.cpp)

add_executable(hello_app hellomain.cpp)
target_link_libraries(hello_app simple_cpp)