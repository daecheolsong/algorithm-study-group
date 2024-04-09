#include <string>
#include <vector>

using namespace std;

int solution(vector<vector<int>> triangle) {
    vector<vector<int>> dp = triangle;
    dp[0][0] = triangle[0][0];
    int n = triangle.size();
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < i + 1; j++) {
            if (j == 0) {
                dp[i][j] = dp[i - 1][j] + triangle[i][j]; // 맨 왼쪽 면
                continue;
            }
            else if (j == i) {
                dp[i][j] = dp[i - 1][j - 1] + triangle[i][j]; // 맨 오른쪽 면
                continue;
            }
            dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
        }
    }
    int max = dp[n - 1][0];
    for (int i = 1; i < n; i++) {
        if (dp[n - 1][i] > max) max = dp[n - 1][i];
    }
    int answer = max;
    return answer;
}