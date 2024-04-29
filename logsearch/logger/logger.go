package logger

import (
	"bufio"
	"os"
	"strings"
)

type LogReader struct {
	path string
}

func NewLogReader(logPath string) *LogReader {
	return &LogReader{
		path: logPath,
	}
}

func (l *LogReader) Find(keywords []string) map[string]int32 {
	m := make(map[string]int32)

	file, err := os.Open(l.path)
	if err != nil {
		panic(err)
	}
	defer file.Close()

	scanner := bufio.NewScanner(file)
	for scanner.Scan() {
		for _, val := range keywords {
			if strings.Contains(scanner.Text(), val) {
				m[val] += 1
			}
		}
	}

	return m
}
