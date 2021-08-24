class SpeechRecognition {

    fun recognise() {
        // Initialization
        // Initialization

        val classifier: AudioClassifier = AudioClassifier.createFromFileAndOptions(context, modelFile)
        // Start recording
        // Start recording
        val record: AudioRecord = classifier.createAudioRecord()
        record.startRecording()
        // Load latest audio samples
        // Load latest audio samples
        val audioTensor: TensorAudio = classifier.createInputTensorAudio()
        audioTensor.load(record)
        // Run inference
        // Run inference
        val results: List<Classifications> = audioClassifier.classify(audioTensor)
    }

}