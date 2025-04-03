#include <iostream>
#include <cmath>

using namespace std;

int main(){
    int t;
    cin >> t;
    for(int a0 = 0; a0 < t; a0++){
        long n;
        cin >> n;
        bool isPrime = false;
        long div = 2;
        while(!isPrime) {
            if(div > static_cast<long>(sqrt(n))) {
                isPrime = true;
                cout<<n<<endl;
            }
            else if(n%div == 0){
                n = n/div;
                div=2;
            }
            else {
                if(div == 2)
                    div++;
                else div+=2;
            }
        }
    }
    return 0;
}