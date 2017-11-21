#include <iostream>
int main(int argc, char const *argv[]) {
  long a,b,t,lim;
  a = 1;
  b = 1;
  t = 0;
  lim = 1;
  std::cout << "Input N:" << '\n';
  std::cin >> lim;
  for(int i = 0; i < lim; i ++){
    std::cout << "Number " << i << "is " << a << '\n';
    t = a;
    a = b;
    b += t;
  }
  return 0;
}
