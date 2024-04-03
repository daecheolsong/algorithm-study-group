from itertools import product
def solution(users, emoticons):
    answer = [0,0]
    
    emoList = list(product([0.9,0.8,0.7,0.6], repeat = len(emoticons)))
    
    
    for discount in emoList:
        
        userEmoList = []
        for i in range(len(users)):
            userEmoList.append([i,[],0,False])
        
        emoRatePriceList = []
        for i,v in enumerate(emoticons):
            # 부동소수점 오류 체크
            emoRatePriceList.append([i, 100 - int(discount[i] * 100),  v * int(10 * discount[i]) // 10])
        
        
        for userNum, user in enumerate(users):
            userRate = user[0]
            userPriceLimit = user[1]
            
            for emoNum, emoRatePrice in enumerate(emoRatePriceList):
                emoRate = emoRatePrice[1]
                emoPrice = emoRatePrice[2]
                
                if emoRate >= userRate:
                    userEmoList[userNum][1].append(emoNum)
                    userEmoList[userNum][2] += emoPrice
            
            if userPriceLimit <= userEmoList[userNum][2]:
                userEmoList[userNum][2] = 0
                userEmoList[userNum][3] = True
        
        tempAnswer = [0,0]
        for i in userEmoList:
            if i[3]:
                tempAnswer[0] +=1
            tempAnswer[1] += i[2]
        
        if answer[0] < tempAnswer[0]:
            answer = tempAnswer
        
        elif answer[0] == tempAnswer[0] and answer[1] < tempAnswer[1]:
            answer = tempAnswer
            
            
                    

    return answer