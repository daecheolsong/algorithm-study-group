#include <string>
#include <vector>
#include <algorithm>

using namespace std;

int visited[10]; // »ç¶÷º°
int maximum = 0;
int sum = 0;

void dfs(vector<vector<int>> ability, int index) {

    if (index == ability[0].size()) {
        maximum = max(maximum, sum);
        return;
    }

    for (int i = 0; i < ability.size(); i++) {
        if (visited[i] == 1) continue;
        visited[i] = 1;
        sum += ability[i][index];
        dfs(ability, index + 1);
        sum -= ability[i][index];
        visited[i] = 0;
    }
}

int solution(vector<vector<int>> ability) {
    int answer = 0;
    dfs(ability, 0);
    answer = maximum;
    return answer;
}
