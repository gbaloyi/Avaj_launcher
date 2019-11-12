find . -name "*.java" > sources.txt
javac -sourcepath . @sources.txt
java avaj.weather.Simulator avaj/scenario.txt

find . -name "*.class" -delete