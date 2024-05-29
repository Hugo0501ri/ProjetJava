package Classes;

public class AdditionalCode extends AbstractAdditionalCode {
    @Override
    protected String generatePythonCode(int exerciseChoice) {
        switch (exerciseChoice) {
            case 1:
                return "print(somme(2,2), somme(7,3), somme(1,6))\n";
            case 2:
                // Add code for exercise 2
            default:
                return "";
        }
    }

    @Override
    protected String generateJavaCode(int exerciseChoice) {
        switch (exerciseChoice) {
            case 1:
                return "public static void main(String args[]){\n" + "System.out.println(somme(2, 2) + \" \" + somme(7, 3) + \" \" + somme(1, 6));\n" + "}\n" + "}";
            case 2:
                // Add code for exercise 2
            default:
                return "";
        }
    }

    @Override
    protected String generateJavaScriptCode(int exerciseChoice) {
        switch (exerciseChoice) {
            case 1:
                return "console.log(somme(2, 2) + \" \" + somme(7, 3) + \" \" + somme(1, 6))\n";

            case 2:
                // Add code for exercise 2
            default:
                return "";
        }
    }

    @Override
    protected String generatePHPCode(int exerciseChoice) {
        switch (exerciseChoice) {
            case 1:
                return "echo somme(2, 2), \" \" , somme(7, 3), \" \", somme(1, 6);\n" + "?>";
            case 2:
                // Add code for exercise 2
            default:
                return "";
        }
    }

    @Override
    protected String generateCCode(int exerciseChoice) {
        switch (exerciseChoice) {
            case 1:
                return "int main() {\n" +
                    "printf(\"%d %d %d\", somme(2, 2), somme(7, 3), somme(1, 6));\n" +
                    "return 0;\n";
            case 2:
                // Add code for exercise 2
            default:
                return "";
        }
    }
}

    


