package org.metasee.database.model;

public class MetaDataSample {
	private static final long serialVersionUID = 48L;
	
	/*For parallel-meta*/
	
	private String phylogeneticTree;
	
	private String classification;
	
	
	
	private  MetaData metaData;
	
	private Integer id;
	
	private String project_name;
	
	private String database_source;
	
	private Integer project_id;
	
	private String metagenome;
	
	private Integer project_id_in_metasee;
	
	private String project_acc_in_metasee;
	
	private Double longitude;
	
	private String title;
	
	private String env_biome;
	
	private String env_matter;
	
	private String country;
	
	private String env_feature;
	
	private String publicornot;
	
	private String depth;
	
	private Double latitude;
	
	private String assigned_from_geo;
	
	private String elevation;
	
	private String collection_date;
	
	private String description;
	
	private String taxon_id;
	
	private String sample_name;
	
	private String anonymized_name;
	
	private String altitude;
	
	private String zhegebuyaole;
	
	private String study_abstract;
	
	private String submit_to_insdc;
	
	private String sff_complete;
	
	private String study_title;
	
	private String miens_compliant;
	
	private String study_alias;
	
	private String investigation_type;
	
	private String metadata_complete;
	
	private String study_description;
	
	private String sample_count;
	
	private String PI_firstname;
	
	private String PI_lastname;
	
	private String project_description;
	
	private String samp_size;
	
	private String PI_organization_url;
	
	private String PI_organization_country;
	
	private String PI_organization_address;
	
	private String PI_organization;
	
	private String project_funding;
	
	private String study_id;
	
	private String sample_id;
	
	private String firstname;
	
	private String lastname;
	
	private String temp;
	
	private String common_name;
	
	private String pmid;
	
	private String organization_country;
	
	private String organization;
	
	private String organization_url;
	
	private String run_date;
	
	private String platform;

	private String experiment_center;
	
	private String sequencing_meth;
	
	private String run_center;
	
	private String experiment_title;
	
	private String experiment_design_description;
	
	private String key_seq;
	
	private String library_construction_protocol;
	
	private String study_center;
	
	private String center_name;

	private String barcode;
	
	private String primer;
	
	private String region;
	
	private String sample_origin_sampling_timezone;
	
	private String sample_origin_continent;
	
	private String sample_origin_longitude;
	
	private String sequencing_sequencing_method;
	
	private String sample_origin_latitude;
	
	private int songChecked;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getProject_name() {
		return project_name;
	}

	public void setProject_name(String project_name) {
		this.project_name = project_name;
	}

	public String getDatabase_source() {
		return database_source;
	}

	public void setDatabase_source(String database_source) {
		this.database_source = database_source;
	}

	public Integer getProject_id() {
		return project_id;
	}

	public void setProject_id(Integer project_id) {
		this.project_id = project_id;
	}

	public String getMetagenome() {
		return metagenome;
	}

	public void setMetagenome(String metagenome) {
		this.metagenome = metagenome;
	}

	public MetaDataSample(MetaData metaData, Integer id, String project_name,
			String database_source, Integer project_id, String metagenome,
			String project_acc_in_metasee, Double longitude, String title,
			String env_biome, String env_matter, String country,
			String env_feature, String publicornot, String depth,
			Double latitude, String assigned_from_geo, String elevation,
			String collection_date, String description, String taxon_id,
			String sample_name, String anonymized_name, String altitude,
			String zhegebuyaole, String study_abstract, String submit_to_insdc,
			String sff_complete, String study_title, String miens_compliant,
			String study_alias, String investigation_type,
			String metadata_complete, String study_description,
			String sample_count, String pI_firstname, String pI_lastname,
			String project_description, String samp_size,
			String pI_organization_url, String pI_organization_country,
			String pI_organization_address, String pI_organization,
			String project_funding, String study_id, String sample_id,
			String firstname, String lastname, String temp, String common_name,
			String pmid, String organization_country, String organization,
			String organization_url, String run_date, String platform,
			String experiment_center, String sequencing_meth,
			String run_center, String experiment_title,
			String experiment_design_description, String key_seq,
			String library_construction_protocol, String study_center,
			String center_name, String barcode, String primer, String region,
			String sample_origin_sampling_timezone,
			String sample_origin_continent, String sample_origin_longitude,
			String sequencing_sequencing_method, String sample_origin_latitude) {
		super();
		this.metaData = metaData;
		this.id = id;
		this.project_name = project_name;
		this.database_source = database_source;
		this.project_id = project_id;
		this.metagenome = metagenome;
		this.project_acc_in_metasee = project_acc_in_metasee;
		this.longitude = longitude;
		this.title = title;
		this.env_biome = env_biome;
		this.env_matter = env_matter;
		this.country = country;
		this.env_feature = env_feature;
		this.publicornot = publicornot;
		this.depth = depth;
		this.latitude = latitude;
		this.assigned_from_geo = assigned_from_geo;
		this.elevation = elevation;
		this.collection_date = collection_date;
		this.description = description;
		this.taxon_id = taxon_id;
		this.sample_name = sample_name;
		this.anonymized_name = anonymized_name;
		this.altitude = altitude;
		this.zhegebuyaole = zhegebuyaole;
		this.study_abstract = study_abstract;
		this.submit_to_insdc = submit_to_insdc;
		this.sff_complete = sff_complete;
		this.study_title = study_title;
		this.miens_compliant = miens_compliant;
		this.study_alias = study_alias;
		this.investigation_type = investigation_type;
		this.metadata_complete = metadata_complete;
		this.study_description = study_description;
		this.sample_count = sample_count;
		PI_firstname = pI_firstname;
		PI_lastname = pI_lastname;
		this.project_description = project_description;
		this.samp_size = samp_size;
		PI_organization_url = pI_organization_url;
		PI_organization_country = pI_organization_country;
		PI_organization_address = pI_organization_address;
		PI_organization = pI_organization;
		this.project_funding = project_funding;
		this.study_id = study_id;
		this.sample_id = sample_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.temp = temp;
		this.common_name = common_name;
		this.pmid = pmid;
		this.organization_country = organization_country;
		this.organization = organization;
		this.organization_url = organization_url;
		this.run_date = run_date;
		this.platform = platform;
		this.experiment_center = experiment_center;
		this.sequencing_meth = sequencing_meth;
		this.run_center = run_center;
		this.experiment_title = experiment_title;
		this.experiment_design_description = experiment_design_description;
		this.key_seq = key_seq;
		this.library_construction_protocol = library_construction_protocol;
		this.study_center = study_center;
		this.center_name = center_name;
		this.barcode = barcode;
		this.primer = primer;
		this.region = region;
		this.sample_origin_sampling_timezone = sample_origin_sampling_timezone;
		this.sample_origin_continent = sample_origin_continent;
		this.sample_origin_longitude = sample_origin_longitude;
		this.sequencing_sequencing_method = sequencing_sequencing_method;
		this.sample_origin_latitude = sample_origin_latitude;
	}
	
	
	
	public MetaDataSample() {
		super();
	}

	public String getProject_acc_in_metasee() {
		return project_acc_in_metasee;
	}

	public void setProject_acc_in_metasee(String project_acc_in_metasee) {
		this.project_acc_in_metasee = project_acc_in_metasee;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getEnv_biome() {
		return env_biome;
	}

	public void setEnv_biome(String env_biome) {
		this.env_biome = env_biome;
	}

	public String getEnv_matter() {
		return env_matter;
	}

	public void setEnv_matter(String env_matter) {
		this.env_matter = env_matter;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEnv_feature() {
		return env_feature;
	}

	public void setEnv_feature(String env_feature) {
		this.env_feature = env_feature;
	}

	public String getPublicornot() {
		return publicornot;
	}

	public void setPublicornot(String publicornot) {
		this.publicornot = publicornot;
	}

	public String getDepth() {
		return depth;
	}

	public void setDepth(String depth) {
		this.depth = depth;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public String getAssigned_from_geo() {
		return assigned_from_geo;
	}

	public void setAssigned_from_geo(String assigned_from_geo) {
		this.assigned_from_geo = assigned_from_geo;
	}

	public String getElevation() {
		return elevation;
	}

	public void setElevation(String elevation) {
		this.elevation = elevation;
	}

	public String getCollection_date() {
		return collection_date;
	}

	public void setCollection_date(String collection_date) {
		this.collection_date = collection_date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTaxon_id() {
		return taxon_id;
	}

	public void setTaxon_id(String taxon_id) {
		this.taxon_id = taxon_id;
	}

	public String getSample_name() {
		return sample_name;
	}

	public void setSample_name(String sample_name) {
		this.sample_name = sample_name;
	}

	public String getAnonymized_name() {
		return anonymized_name;
	}

	public void setAnonymized_name(String anonymized_name) {
		this.anonymized_name = anonymized_name;
	}

	public String getAltitude() {
		return altitude;
	}

	public void setAltitude(String altitude) {
		this.altitude = altitude;
	}

	public String getZhegebuyaole() {
		return zhegebuyaole;
	}

	public void setZhegebuyaole(String zhegebuyaole) {
		this.zhegebuyaole = zhegebuyaole;
	}

	public String getStudy_abstract() {
		return study_abstract;
	}

	public void setStudy_abstract(String study_abstract) {
		this.study_abstract = study_abstract;
	}

	public String getSubmit_to_insdc() {
		return submit_to_insdc;
	}

	public void setSubmit_to_insdc(String submit_to_insdc) {
		this.submit_to_insdc = submit_to_insdc;
	}

	public String getSff_complete() {
		return sff_complete;
	}

	public void setSff_complete(String sff_complete) {
		this.sff_complete = sff_complete;
	}

	public String getStudy_title() {
		return study_title;
	}

	public void setStudy_title(String study_title) {
		this.study_title = study_title;
	}

	public String getMiens_compliant() {
		return miens_compliant;
	}

	public void setMiens_compliant(String miens_compliant) {
		this.miens_compliant = miens_compliant;
	}

	public String getStudy_alias() {
		return study_alias;
	}

	public void setStudy_alias(String study_alias) {
		this.study_alias = study_alias;
	}

	public String getInvestigation_type() {
		return investigation_type;
	}

	public void setInvestigation_type(String investigation_type) {
		this.investigation_type = investigation_type;
	}

	public String getMetadata_complete() {
		return metadata_complete;
	}

	public void setMetadata_complete(String metadata_complete) {
		this.metadata_complete = metadata_complete;
	}

	public String getStudy_description() {
		return study_description;
	}

	public void setStudy_description(String study_description) {
		this.study_description = study_description;
	}

	public String getSample_count() {
		return sample_count;
	}

	public void setSample_count(String sample_count) {
		this.sample_count = sample_count;
	}

	public String getPI_firstname() {
		return PI_firstname;
	}

	public void setPI_firstname(String pI_firstname) {
		PI_firstname = pI_firstname;
	}

	public String getPI_lastname() {
		return PI_lastname;
	}

	public void setPI_lastname(String pI_lastname) {
		PI_lastname = pI_lastname;
	}

	public String getProject_description() {
		return project_description;
	}

	public void setProject_description(String project_description) {
		this.project_description = project_description;
	}

	public String getSamp_size() {
		return samp_size;
	}

	public void setSamp_size(String samp_size) {
		this.samp_size = samp_size;
	}

	public String getPI_organization_url() {
		return PI_organization_url;
	}

	public void setPI_organization_url(String pI_organization_url) {
		PI_organization_url = pI_organization_url;
	}

	public String getPI_organization_country() {
		return PI_organization_country;
	}

	public void setPI_organization_country(String pI_organization_country) {
		PI_organization_country = pI_organization_country;
	}

	public String getPI_organization_address() {
		return PI_organization_address;
	}

	public void setPI_organization_address(String pI_organization_address) {
		PI_organization_address = pI_organization_address;
	}

	public String getPI_organization() {
		return PI_organization;
	}

	public void setPI_organization(String pI_organization) {
		PI_organization = pI_organization;
	}

	public String getProject_funding() {
		return project_funding;
	}

	public void setProject_funding(String project_funding) {
		this.project_funding = project_funding;
	}

	public String getStudy_id() {
		return study_id;
	}

	public void setStudy_id(String study_id) {
		this.study_id = study_id;
	}

	public String getSample_id() {
		return sample_id;
	}

	public void setSample_id(String sample_id) {
		this.sample_id = sample_id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getTemp() {
		return temp;
	}

	public void setTemp(String temp) {
		this.temp = temp;
	}

	public String getCommon_name() {
		return common_name;
	}

	public void setCommon_name(String common_name) {
		this.common_name = common_name;
	}

	public String getPmid() {
		return pmid;
	}

	public void setPmid(String pmid) {
		this.pmid = pmid;
	}

	public String getOrganization_country() {
		return organization_country;
	}

	public void setOrganization_country(String organization_country) {
		this.organization_country = organization_country;
	}

	public String getOrganization() {
		return organization;
	}

	public void setOrganization(String organization) {
		this.organization = organization;
	}

	public String getOrganization_url() {
		return organization_url;
	}

	public void setOrganization_url(String organization_url) {
		this.organization_url = organization_url;
	}

	public String getRun_date() {
		return run_date;
	}

	public void setRun_date(String run_date) {
		this.run_date = run_date;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getExperiment_center() {
		return experiment_center;
	}

	public void setExperiment_center(String experiment_center) {
		this.experiment_center = experiment_center;
	}

	public String getSequencing_meth() {
		return sequencing_meth;
	}

	public void setSequencing_meth(String sequencing_meth) {
		this.sequencing_meth = sequencing_meth;
	}

	public String getRun_center() {
		return run_center;
	}

	public void setRun_center(String run_center) {
		this.run_center = run_center;
	}

	public String getExperiment_title() {
		return experiment_title;
	}

	public void setExperiment_title(String experiment_title) {
		this.experiment_title = experiment_title;
	}

	public String getExperiment_design_description() {
		return experiment_design_description;
	}

	public void setExperiment_design_description(
			String experiment_design_description) {
		this.experiment_design_description = experiment_design_description;
	}

	public String getKey_seq() {
		return key_seq;
	}

	public void setKey_seq(String key_seq) {
		this.key_seq = key_seq;
	}

	public String getLibrary_construction_protocol() {
		return library_construction_protocol;
	}

	public void setLibrary_construction_protocol(
			String library_construction_protocol) {
		this.library_construction_protocol = library_construction_protocol;
	}

	public String getStudy_center() {
		return study_center;
	}

	public void setStudy_center(String study_center) {
		this.study_center = study_center;
	}

	public String getCenter_name() {
		return center_name;
	}

	public void setCenter_name(String center_name) {
		this.center_name = center_name;
	}

	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}

	public String getPrimer() {
		return primer;
	}

	public void setPrimer(String primer) {
		this.primer = primer;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSample_origin_sampling_timezone() {
		return sample_origin_sampling_timezone;
	}

	public void setSample_origin_sampling_timezone(
			String sample_origin_sampling_timezone) {
		this.sample_origin_sampling_timezone = sample_origin_sampling_timezone;
	}

	public String getSample_origin_continent() {
		return sample_origin_continent;
	}

	public void setSample_origin_continent(String sample_origin_continent) {
		this.sample_origin_continent = sample_origin_continent;
	}

	public String getSample_origin_longitude() {
		return sample_origin_longitude;
	}

	public void setSample_origin_longitude(String sample_origin_longitude) {
		this.sample_origin_longitude = sample_origin_longitude;
	}

	public String getSequencing_sequencing_method() {
		return sequencing_sequencing_method;
	}

	public void setSequencing_sequencing_method(String sequencing_sequencing_method) {
		this.sequencing_sequencing_method = sequencing_sequencing_method;
	}

	public String getSample_origin_latitude() {
		return sample_origin_latitude;
	}

	public void setSample_origin_latitude(String sample_origin_latitude) {
		this.sample_origin_latitude = sample_origin_latitude;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
/*
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((metagenome == null) ? 0 : metagenome.hashCode());
		result = prime * result
				+ ((project_id == null) ? 0 : project_id.hashCode());
		result = prime
				* result
				+ ((project_id_in_metasee == null) ? 0 : project_id_in_metasee
						.hashCode());
		result = prime * result
				+ ((project_name == null) ? 0 : project_name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MetaDataSample other = (MetaDataSample) obj;
		if (metagenome == null) {
			if (other.metagenome != null)
				return false;
		} else if (!metagenome.equals(other.metagenome))
			return false;
		if (project_id == null) {
			if (other.project_id != null)
				return false;
		} else if (!project_id.equals(other.project_id))
			return false;
		if (project_id_in_metasee == null) {
			if (other.project_id_in_metasee != null)
				return false;
		} else if (!project_id_in_metasee.equals(other.project_id_in_metasee))
			return false;
		if (project_name == null) {
			if (other.project_name != null)
				return false;
		} else if (!project_name.equals(other.project_name))
			return false;
		return true;
	}
*/
	public MetaData getMetaData() {
		return metaData;
	}

	public void setMetaData(MetaData metaData) {
		this.metaData = metaData;
	}

	public Integer getProject_id_in_metasee() {
		return project_id_in_metasee;
	}

	public void setProject_id_in_metasee(Integer project_id_in_metasee) {
		this.project_id_in_metasee = project_id_in_metasee;
	}

	public int getSongChecked() {
		return songChecked;
	}

	public void setSongChecked(int songChecked) {
		this.songChecked = songChecked;
	}

	public String getPhylogeneticTree() {
		return phylogeneticTree;
	}

	public void setPhylogeneticTree(String phylogeneticTree) {
		this.phylogeneticTree = phylogeneticTree;
	}

	public String getClassification() {
		return classification;
	}

	public void setClassification(String classification) {
		this.classification = classification;
	}
	
}
