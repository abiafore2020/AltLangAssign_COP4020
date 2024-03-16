import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Cell {
  // Attributes found in cells.csv
    private String oem;
    private String model;
    private Integer launchAnnounced;
    private String launchStatus;
    private String bodyDimensions;
    private Float bodyWeight;
    private String bodySim;
    private String displayType;
    private Float displaySize;
    private String displayResolution;
    private String featuresSensors;
    private String platformOs;

    // Constructor
    public Cell(String oem, String model, String launchAnnounced, String launchStatus, String bodyDimensions,
                String bodyWeight, String bodySim, String displayType, String displaySize, String displayResolution,
                String featuresSensors, String platformOs) throws IllegalArgumentException {
        this.oem = oem;
        this.model = model;
        this.launchAnnounced = extractYear(launchAnnounced);
        this.launchStatus = launchStatus;
        this.bodyDimensions = bodyDimensions;
        this.bodyWeight = extractWeight(bodyWeight);
        this.bodySim = bodySim;
        this.displayType = displayType;
        this.displaySize = extractSize(displaySize);
        this.displayResolution = displayResolution;
        this.featuresSensors = featuresSensors;
        this.platformOs = extractPlatform(platformOs);
    }

    // Getters and setters

    // toString method - easiest to do, can extract data that needs to be changed later
    @Override
    public String toString() {
        return "Cell{" +
                "oem='" + oem + '\'' +
                ", model='" + model + '\'' +
                ", launchAnnounced=" + launchAnnounced +
                ", launchStatus='" + launchStatus + '\'' +
                ", bodyDimensions='" + bodyDimensions + '\'' +
                ", bodyWeight=" + bodyWeight +
                ", bodySim='" + bodySim + '\'' +
                ", displayType='" + displayType + '\'' +
                ", displaySize=" + displaySize +
                ", displayResolution='" + displayResolution + '\'' +
                ", featuresSensors='" + featuresSensors + '\'' +
                ", platformOs='" + platformOs + '\'' +
                '}';
    }

    // Transforming and extracting data 

    // Extract Year
    private Integer extractYear(String value) {
        try {
            Matcher matcher = Pattern.compile("\\d{4}").matcher(value);
            if (matcher.find()) {
                return Integer.parseInt(matcher.group());
            } else {
                return null;
            }
        } catch (NumberFormatException e) {
            return null;
        }
    }

    // Extract Weight
    private Float extractWeight(String value) {
        try {
            Matcher matcher = Pattern.compile("\\d+(\\.\\d+)?").matcher(value);
            if (matcher.find()) {
                return Float.parseFloat(matcher.group());
            } else {
                return null;
            }
        } catch (NumberFormatException e) {
            return null;
        }
    }

    // Extract Size
    private Float extractSize(String value) {
        try {
            Matcher matcher = Pattern.compile("\\d+(\\.\\d+)?").matcher(value);
            if (matcher.find()) {
                return Float.parseFloat(matcher.group());
            } else {
                return null;
            }
        } catch (NumberFormatException e) {
            return null;
        }
    }

    // Extract Platform
    private String extractPlatform(String value) {
        if (value == null) return null;
        String[] parts = value.split(",");
        return parts[0].trim();
    }
}
