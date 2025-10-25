# Rose Classification using CNN

This project was developed as part of **CSC462: Machine Learning** at King Saud University.  
It implements a **Convolutional Neural Network (CNN)** for binary image classification to distinguish **roses** from other flowers.

---

## Project Description
The program:
1. Preprocesses the dataset and applies **data augmentation** (rotation, zoom, shifts, flips).
2. Splits the dataset into **training (70%)**, **validation (15%)**, and **test (15%)** sets.
3. Builds a **CNN model** with convolution, pooling, dropout, and batch normalization layers.
4. Trains the model with **early stopping** to avoid overfitting.
5. Evaluates the model using:
   - Precision, Recall, F1-score, Accuracy
   - Confusion matrices
   - ROC curves
   - Loss and accuracy curves

---

## Tools & Requirements
- **Python 3.9+**
- **TensorFlow / Keras**
- **scikit-learn**
- **NumPy**
- **Pandas**
- **Matplotlib**
- **Seaborn**

---

## 📊 Dataset
We used a subset of the [Flowers Dataset on Kaggle](https://www.kaggle.com/datasets/imsparsh/flowers-dataset).  
From the original dataset, we selected:
- 100 images of roses
- 25 images of tulips
- 25 images of dandelions
- 25 images of sunflowers
- 25 images of daisies

We also applied data augmentation (rotation, zoom, shifting), which doubled the dataset size.

---

## Project Structure
```
RoseClassification.ipynb # Source code (CNN implementation)
RoseClassification_report.pdf # Project report
```

---

## 👥 Developed by
This project was developed by :
- [Hissah Ibn Qurmulah](https://github.com/hessakhs) 
- [Reem Alsuhaim](https://github.com/Reem-Alsuhaim)
- [Remas Almania](https://github.com/RemasAlmania)
