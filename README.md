## Bash Cartesian Product

### Contents:  
#### src:
1. CartesianProduct.java-Java Implementation of Bash Cartesian product
2. UnclosedBracket.java- Code to check if the paranthesis are valid
3. CartesianProductTest.java-Unit Test cases to check the correctness of the code

#### library:
Jar files to run Junit Tests:  
* hamcrest-core.jar
* junit.jar

### Instructions on how to run the code:
1. Clone this repository and navigate to src folder:
```
git clone https://github.com/gsrajadh/Bash-Cartesian-Product.git
cd Bash-Cartesian-Product/src
```

2. Compile the code using the following command:  
```
javac CartesianProduct.java
```

2. The code takes command line arguments which can be executed as the following example:  
```
java CartesianProduct "a{b,c}d{e,f,g}hi"
```

3. Compile JUnit Tests:  
```
javac -cp .:"/Users/gargi/Bash-Cartesian-Product/library/*" CartesianProductTest.java
```

4. Run JUnit Tests:  
```
java -cp .:"../library/*" org.junit.runner.JUnitCore CartesianProductTest
```
