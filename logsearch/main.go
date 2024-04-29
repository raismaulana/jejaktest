package main

import (
	"encoding/json"
	"fmt"
	"logsearch/logger"
	"os"
)

const logPath string = "logs/log.log"

func main() {
	keywords := os.Args[1:]

	l := logger.NewLogReader(logPath)
	result := l.Find(keywords)
	print(result)
}

func print(in map[string]int32) {
	b, err := json.MarshalIndent(in, "", "  ")
	if err != nil {
		panic(err)
	}
	fmt.Println(string(b))
}
