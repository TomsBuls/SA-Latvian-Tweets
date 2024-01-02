# Decoding Sentiments: A Comparative Evaluation of Machine and Deep Learning Techniques in Analyzing Public Sentiment Towards the Latvian Government Post 2022 Elections

## Table of Contents:
1. [Introduction](#introduction)
2. [Dataset Description](#dataset-description)
3. [Instructions](#instructions)
4. [Dependencies](#dependencies)
5. [Usage](#usage)
6. [License](#license)

## Introduction:
In today's digital era, understanding public sentiment towards the government is crucial for democratic accountability, effective policy-making, and maintaining strong government-citizen connections—especially in the wake of global events like the Covid-19 pandemic and geopolitical conflicts. This project focuses on the nuanced task of sentiment analysis in Latvian-language tweets, embarking on a mission to address a pronounced research gap. The unique linguistic landscape of Latvian, marked by distinctive sentence structures and linguistic intricacies, presents an unexplored research area in sentiment analysis methodologies. The research aim is twofold: first, to  curate a comprehensive dataset reflecting public opinions post the Autumn 2022 government elections in Latvia, and second, to develop a semantic sentiment analysis model tailored to the Latvian language. The approach not only seeks to deepen the understanding of public sentiment but also strives to make a contribution to the broader field of sentiment analysis research in the Latvian language.



## Dataset decription:
The 'Datasets' directory contains links to the raw dataset and four preprocessed datasets. The preprocessed datasets are generated using the 'Preprocessing' Jupyter Notebook.

### Lemmatized datasets:
1. Full dataset: Contains full text data of lemmatized Latvian tweets.
2. Labelled dataset: Subset of lemmatized tweets, human annotated for ML and deep learning classification.

### Not Lemmatized datasets:
1. Full dataset: Contains full text data of Latvian tweets without lemmatization.
2. Labelled dataset: Subset of not lemmatized tweets.

Lemmatized and not lemmatized datasets are used together to create ML and deep learning classification models. Assessing the models on both datasets helps evaluate the impact of linguistic preprocessing.



## Instructions:

The Jupyter Notebooks can be used replicate the results of the research:

1. The 'Preprocessing' Jupyter Notebook applies a variety of preprocessing steps to generate the four datasets described above.
The code can be inspected to observe how the preprocessing steps modify the textual data at each stage. 

2. The 'Baseline_Classifiers' and 'BERT_model' Jupyter Notebooks provide information on how the ML and deep learning classifier models have been trained 
and tested on the datasets.
The code can be inspected to observe the comparison of performance metrics, including accuracy, precision, recall, f1-score, confusion matrices, true positives (TP), false positives (FP), true negatives (TN), false negatives (FN), ROC/AUC curves, training and validation losses, and a parameter grid search options for each of the five classifiers using lemmatized and not lemmatized datasets. (The time to run certain models can be significant.)

3. The 'BERT_model_testing' Jypyter notebook imports the proposed BERT model for sentiment classification and applies sentiment prediction for a sample of user defined tweets in Latvian.
The code in this notebook shows how the BERT model can be used for sentiment classification of previously unseen Latvian tweets.

Feel free to explore and run the notebooks to understand the research process and results.


***** 
To replicate the data preprocessing steps, both the Jupyter Notebook 'Preprocessing' and Java based project "StemmerLV: Latvian lemmatizer and stemmer for Java" with the adapted program 'TweetLemmatizer.java' needs to be used.

Based on the publicly available Java program (see the link below in the 'Dependencies' list), a TweetLemmatizer.java program is written to utilise the lemmatization functionality for words in the tweets.

First, the Jupyter Notebook 'Preprocessing' is executed until the point the tweets are preprocessed and ready for lemmatization.
Then, the file ready for lemmatization is exported to a csv file. The exported csv file is input to Java program "TweetLemmatizer", which performs lemmatization and outputs lemmatized text to another csv file. Then, the csv file is read back in using the Jupyter Notebok 'Preprocessing' for further analysis. 

These steps are executed for the full and labelled datasets.
*****


## Dependencies:

Python dependencies:

Essential Libraries:
- pandas (link: https://pandas.pydata.org/docs/getting_started/install.html)
- numpy (link: https://numpy.org/install/)

Machine Learning (NB, SVM, fasttext) and Preprocessing:
- imbalanced-learn (link: https://imbalanced-learn.org/stable/references/generated/imblearn.over_sampling.RandomOverSampler.html)
- scikit-learn (link: https://scikit-learn.org/stable/install.html)
- fasttext (link: https://pypi.org/project/fasttext/)

Visualization:
- matplotlib (link: https://matplotlib.org/stable/users/installing/index.html)
- seaborn (link: https://seaborn.pydata.org/installing.html)

Deep Learning (CNN, BERT):
- tensorflow (link: https://www.tensorflow.org/install)
- keras (link: https://pypi.org/project/keras/)

Additional Utilities:
- joblib (https://joblib.readthedocs.io/en/latest/installing.html)

Transformers and Torch Utilities (BERT):
- transformers (link: https://huggingface.co/docs/transformers/index)

- torch (link: https://pytorch.org/)

	
Java dependencies:

Link to Java file for lemmatization: https://ortus0m.rtu.lv/science/lv/datamodule/513

## Usage: 
The BERT model is intended to be used with the LVBERT tokenizer. As demonstrated in the 'BERT_model_testing' Jupyter Notebook, it can then be employed to predict the sentiment of varying length Latvian tweets or comments, particularly those related to political communication. The lemmatized BERT model achieves a 93% accuracy.  



## License:
This project is licensed under the MIT License.
