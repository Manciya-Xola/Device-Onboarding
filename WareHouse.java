public class WareHouse
{
   private int warehouse_;
   private int section;
   private int row;
   private int shelf;
   private int segment_number;
   private String segment;

   public WareHouse(int warehouse, int section, int row, int shelf,int segment_number, String segment)
   {
      this.warehouse_ = warehouse;
      this.section= section;
      this.row = row;
      this.shelf = shelf;
      this.segment_number = segment_number;
      this.segment = segment;
   }
   
   public int GetWareHouseNumber()
   {
      return warehouse_;
   }
   
   public int GetSectionNumber()
   {
      return section;
   }
   
   public int GetRowNumber()
   {
      return row;
   }
   
   public int GetShelfNumber()
   {
      return shelf;
   }
   
   public int GetSegmentNumber()
   {
      return segment_number;
   }
   public String GetSegment()
   {
      return segment;
   }
   
   public String toString()
   {
      return "\n\tWarehouse Number: "+warehouse_+
             "\n\tSection: "+section+
             "\n\tRow: "+row+
             "\n\tShelf: "+shelf+
             "\n\tSegment Number"+segment_number+
             "'n\tSegment: "+segment;
   }
}