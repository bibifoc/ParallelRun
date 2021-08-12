package parallelRun;

public class DistributionLine {
    int id;
    int parallel_run_extraction_fk;
    String source_env;
    int ol_id;
    String ol_file_name;
    String ol_file_path;
    String ol_media_type;
    String ol_file_format;
    String ol_file_compression_format;
    String ol_status;
    String ol_created_at;
    int dis_id;
    String dis_input_filename;
    String dis_remote_filename;
    String dis_destination;
    String dis_posting_time;
    String dis_ftp_time;
    String dis_transfer_status;
    String dis_meta_data;
    String fnm_file_name_mask_id;
    int fnm_id;
    String ct_contract_id;
    int ct_id;
    String sub_subscriber_id;
    int sub_id;
    int sub_subscriber_fk;
    String sub_alias;
    String rcpt_subscriber_id;
    int rcpt_id;
    String migr_action;
    String migr_phs_ind;
    String migr_map_to_sub;
    String cmp_dis_destination;
    String cmp_file_name_mask_id;
    String cmp_subscriber;
    String cmp_srecipient;
    String cmp_input_file_name;
    String cmp_ignore_reason;

    public void testDisplay(){
        System.out.println("id:" + id + " source_env:"+source_env);
    }
}
