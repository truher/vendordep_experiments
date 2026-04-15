#include "hello.h"

extern "C" {
team100::Hello* Hello() {
    return new team100::Hello();
}

int Hello_add(team100::Hello* obj, int a, int b) {
    return obj->add(a, b);
}

void Hello_delete(team100::Hello* obj) {
    delete obj;
}
}