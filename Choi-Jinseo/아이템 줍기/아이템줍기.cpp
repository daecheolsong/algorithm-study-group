#include <iostream>
#include <string>
#include <vector>
#include <queue>
using namespace std;
//
bool table[102][102];
bool visited[102][102];

struct Position
{
    int x;
    int y;
    int distance;
};

int solution(vector<vector<int>> rectangle, int characterX, int characterY, int itemX, int itemY) {
    // 도형 1로 채우기
    for (int i = 0; i < rectangle.size(); i++) {
        for (int j = 0; j < rectangle[i].size(); j++) {
            rectangle[i][j] = rectangle[i][j] * 2; // 예외처리를 위해 2배
        }
        for (int x = rectangle[i][0]; x <= rectangle[i][2]; x++) {
            for (int y = rectangle[i][1]; y <= rectangle[i][3]; y++) {
                table[x][y] = true;
            }
        }
    }
    // 내부 0으로 채우기
    for (int i = 0; i < rectangle.size(); i++) {
        for (int x = rectangle[i][0] + 1; x < rectangle[i][2]; x++) {
            for (int y = rectangle[i][1] + 1; y < rectangle[i][3]; y++) {
                table[x][y] = false;
            }
        }
    }
    // bfs
    queue<Position> que;
    que.push({ characterX * 2,characterY * 2,0 });
    visited[characterX * 2][characterY * 2] = true;

    int dx[4] = { 1,-1,0,0 };
    int dy[4] = { 0,0,-1,1 };

    while (!que.empty())
    {
        Position dot = que.front();
        que.pop();

        if (dot.x == itemX * 2 && dot.y == itemY * 2)
        {
            return dot.distance / 2;
        }

        for (int i = 0; i < 4; i++)
        {
            int nx = dot.x + dx[i];
            int ny = dot.y + dy[i];
            if (nx > 0 && nx <= 100 && ny > 0 && ny <= 100 && visited[nx][ny] == false && table[nx][ny] == true) {
                visited[nx][ny] = true;
                que.push({ nx,ny,dot.distance + 1 });
            }
        }
    }
}