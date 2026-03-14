# SENG 272 – Lab Assignment 2
## Software System Quality Evaluation (ISO/IEC 25010)

### Project Description
This project evaluates the quality of software systems based on the ISO/IEC 25010 Software Quality Model using Java Object-Oriented Programming (OOP) and Java Collections Framework.

The program allows users to select a software system, enter measured metric values, and generate a quality evaluation report including dimension scores, overall quality score, and gap analysis.

### Features
- Object-Oriented Programming principles (Encapsulation)
- ArrayList for managing quality criteria
- HashMap for organizing software systems by category
- Weighted quality score calculation
- ISO/IEC 25010 quality characteristic evaluation
- Identification of the weakest quality dimension
- Console-based report generation

### ISO/IEC 25010 Quality Characteristics Used
- Functional Suitability
- Reliability
- Performance Efficiency
- Maintainability
- Security
- Usability

### Project Structure
Criterion.java  
QualityDimension.java  
SWSystem.java  
SWSystemData.java  
Main.java  

### How to Run

Compile the project:

javac *.java

Run the program:

java Main

### Example Workflow
1. Select a software category (e.g., Web or Mobile)
2. Select a system from the list
3. Enter measured metric values for each criterion
4. The program calculates quality scores and prints the evaluation report.

### Example Output
The program generates a report including:
- Quality scores for each ISO 25010 dimension
- Overall system quality score
- Quality level classification
- Gap analysis identifying the weakest dimension

### Author
SENG 272 Software Engineering Lab Assignment
