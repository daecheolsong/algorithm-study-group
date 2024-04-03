#include <string>
#include <vector>

using namespace std;

int solution(int n, vector<int> tops) {
    int answer = 0;

    int* orr = new int[n]; // 있는거 (오른쪽 아래 마름모)
    int* xrr = new int[n]; // 없는거

    orr[0] = 1; // 오른쪽 마름모 O 경우
    xrr[0] = 2 + tops[0]; // X 경우의 수

    //점화식 유도
    //orr[1] = orr[0] * 1 + xrr[0] * 1;
    //xrr[1] = orr[0] * (1 + tops[1]) + xrr[0] * (2 + tops[1]);

    for (int i = 1; i < n; i++) {
        orr[i] = orr[i - 1] * 1 + xrr[i - 1] * 1;
        orr[i] %= 10007;
        xrr[i] = orr[i - 1] * (1 + tops[i]) + xrr[i - 1] * (2 + tops[i]);
        xrr[i] %= 10007;
    }
    answer = (orr[n - 1] + xrr[n - 1]) % 10007;

    delete[] orr, xrr;

    return answer;
}