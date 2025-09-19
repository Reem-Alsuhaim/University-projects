package AI;

import weka.filters.Filter;
import weka.filters.unsupervised.attribute.ReplaceMissingValues;
import weka.filters.unsupervised.attribute.NumericToNominal;
import weka.core.Instances;
import weka.core.converters.ConverterUtils.DataSource;
import java.util.Random;
import weka.classifiers.Classifier;
import weka.classifiers.trees.J48;
import weka.classifiers.Evaluation;

public class AI_project {

	    public static void main(String[] args) throws Exception {
	        // Load data set
	        DataSource source = new DataSource("C:\\Users\\reems\\Downloads\\diabetes.csv"); // this is differ from device to another
	        Instances data = source.getDataSet();

	        // Set the class attribute to outcome
	        data.setClassIndex(data.numAttributes() - 1);


	        // Convert the class attribute to nominal (interpreted by the Weka as numeric values.)
	        // for J48 outcome needs to be nominal.
	        if (data.classAttribute().isNumeric()) {
	            NumericToNominal convert = new NumericToNominal();
	            convert.setAttributeIndices("last"); 
	            convert.setInputFormat(data);
	            data = Filter.useFilter(data, convert);
	        }
	        
	        
	        // Split data into training and testing sets 70/30
	        int trainSize = (int) Math.round(data.numInstances() * 0.7);
	        int testSize = data.numInstances() - trainSize;
	        Instances trainData = new Instances(data, 0, trainSize);
	        Instances testData = new Instances(data, trainSize, testSize);

	        // Train the decision tree
	        Classifier tree = new J48();
	        tree.buildClassifier(trainData);
	       
	        
	        // Print the decision tree
	        System.out.println(tree);
	        
	        // Evaluate the model
	        Evaluation eval = new Evaluation(trainData);
	        eval.evaluateModel(tree, testData);

	        // Print results
	        System.out.println(eval.toSummaryString("\n==Results:==\n-------------------------------------------------------------------\n", false));
	        

	        System.out.println("==Confusion Matrix:==");
	        // Get TP , FP , FN , TN 
	        int positiveClassIndex = 1; // "diabetes = 1" 
	        double TP = eval.numTruePositives(positiveClassIndex);
	        double FP = eval.numFalsePositives(positiveClassIndex);
	        double FN = eval.numFalseNegatives(positiveClassIndex);
	        double TN = eval.numTrueNegatives(positiveClassIndex);

	        // Print TP , FP , FN , TN
	        System.out.println("True  Positives (TP): " + TP); // Has diabetes and has been correctly classified.
	        System.out.println("False Positives (FP): " + FP); // Not diabetic and was misclassified as having diabetes.
	        System.out.println("False Negatives (FN): " + FN); // Diabetic and was misclassified as not having diabetes.
	        System.out.println("True  Negatives (TN): " + TN); // Not diabetic and has been correctly classified.

	        
	        // Compute Precision and Recall:
	        double precision = eval.precision(positiveClassIndex);
	        double recall = eval.recall(positiveClassIndex);
	        double F1Score = eval.fMeasure(positiveClassIndex);
	        System.out.println("\n==Accuracy:==");
	        System.out.println("Precision: " + Math.round(precision*100)+"%");
	        System.out.println("Recall   : " + Math.round(recall*100)+"%");
	        System.out.println("F1-Score : " + Math.round(F1Score*100)+"%");
	       
	        System.out.println("-------------------------------------------------------------------");
	        
	     
	    }
	}