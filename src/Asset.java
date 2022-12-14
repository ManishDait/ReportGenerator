public class Asset {
    private String assetId;
    private String assetName;
    private String assetExpiry;

    public Asset(String assetId, String assetName, String assetExpiry){
        if(assetId.matches("(DSK|LTP|IPH){1}-[0-9]{6}(H|L|h|l){1}"))
          this.assetId = assetId;
        this.assetName = assetName;
        this.assetExpiry = assetExpiry;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId){
        if(assetId.matches("(DSK|LTP|IPH){1}-[0-9]{6}(H|L|h|l){1}"))
         this.assetId = assetId;
    }

    public String getAssetName() {
        return assetName;
    }

    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }

    public String getAssetExpiry() {
        return assetExpiry;
    }

    public void setAssetExpiry(String assetExpiry) {
        this.assetExpiry = assetExpiry;
    }

    @Override
    public String toString() {
        return "Assets [assetId=" + assetId + ", assetName=" + assetName + ", assetExpiry=" + assetExpiry
                + "]";
    }

}
