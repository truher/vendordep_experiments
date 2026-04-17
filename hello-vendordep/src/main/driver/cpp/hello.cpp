#include "hello.h"

#include <iostream>
namespace team100 {
Hello::Hello() {
    std::cout << "Hello: constructing" << std::endl;
}
Hello::~Hello() {
    std::cout << "Hello: deleting" << std::endl;
}
int Hello::add(int a, int b) {
    std::cout << "Hello: adding " << a << " + " << b << std::endl;
    return a + b;
};
}  // namespace team100