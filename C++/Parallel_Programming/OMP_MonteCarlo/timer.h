//
//  timer.h
//  Created by James Williams on 10/23/15.
//
#include <time.h>
#ifndef timer_h
#define timer_h

class timer {
private:
    unsigned long begTime;

public:
    void start() {
        begTime = clock();
    }

    unsigned long elapsedTime() {
        return (clock() - begTime);
    }
};


#endif /* timer_h */
