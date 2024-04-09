#include <string>
#include <vector>

using namespace std;

int emo_plus_max = 0;
int price_max = 0;
vector<pair<int, int>> emoVR; // 이모티콘의 Value(할인된 가격), Rate(할인율)

void compare_and_reset(int emo_plus, int total) {
    if (emo_plus > emo_plus_max) {
        emo_plus_max = emo_plus;
        price_max = total;
    }
    else if (emo_plus == emo_plus_max) {
        if (total > price_max) price_max = total;
    }
}
void backTracking(int cnt, vector<int> emoticons, vector<vector<int>> users) {
    if (cnt == emoticons.size()) {
        int emo_plus = 0;
        int total = 0;
        for (int i = 0; i < users.size(); i++) {
            int temp = 0;
            for (int j = 0; j < emoticons.size(); j++) {
                if (users[i][0] <= emoVR[j].second) {
                    temp += emoVR[j].first;
                }
            }
            if (temp >= users[i][1]) emo_plus++;
            else total += temp;
        }
        compare_and_reset(emo_plus, total);
        return;
    }
    for (int i = 1; i <= 4; i++) {
        int value = (10 - i) * emoticons[cnt] / 10;
        emoVR.push_back(make_pair(value, i * 10));
        backTracking(cnt + 1, emoticons, users);
        emoVR.pop_back();
    }
}

vector<int> solution(vector<vector<int>> users, vector<int> emoticons) {
    vector<int> answer;
    backTracking(0, emoticons, users);
    answer.push_back(emo_plus_max);
    answer.push_back(price_max);
    return answer;
}