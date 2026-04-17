#include <iostream>

#include "hello.h"

using namespace team100;
int main() {
    Hello* hello = new Hello();
    int c = hello->add(1, 2);
    std::cout << "result " << c << std::endl;
    delete hello;
}