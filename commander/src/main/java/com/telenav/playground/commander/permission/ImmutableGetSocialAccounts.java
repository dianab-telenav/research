package com.telenav.playground.commander.permission;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.Generated;

/**
 * Immutable implementation of {@link GetSocialAccounts}.
 * <p>
 * Use the builder to create immutable instances:
 * {@code ImmutableGetSocialAccounts.builder()}.
 */
@SuppressWarnings({"all"})
@Generated({"Immutables.generator", "GetSocialAccounts"})
final class ImmutableGetSocialAccounts
    implements GetSocialAccounts {
  private final String networkerId;

  private ImmutableGetSocialAccounts(String networkerId) {
    this.networkerId = networkerId;
  }

  /**
   * @return The value of the {@code networkerId} attribute
   */
  @Override
  public String networkerId() {
    return networkerId;
  }

  /**
   * Copy the current immutable object by setting a value for the {@link GetSocialAccounts#networkerId() networkerId} attribute.
   * An equals check used to prevent copying of the same value by returning {@code this}.
   * @param value A new value for networkerId
   * @return A modified copy of the {@code this} object
   */
  public final ImmutableGetSocialAccounts withNetworkerId(String value) {
    if (this.networkerId.equals(value)) return this;
    String newValue = Objects.requireNonNull(value, "networkerId");
    return new ImmutableGetSocialAccounts(newValue);
  }

  /**
   * This instance is equal to all instances of {@code ImmutableGetSocialAccounts} that have equal attribute values.
   * @return {@code true} if {@code this} is equal to {@code another} instance
   */
  @Override
  public boolean equals(Object another) {
    if (this == another) return true;
    return another instanceof ImmutableGetSocialAccounts
        && equalTo((ImmutableGetSocialAccounts) another);
  }

  private boolean equalTo(ImmutableGetSocialAccounts another) {
    return networkerId.equals(another.networkerId);
  }

  /**
   * Computes a hash code from attributes: {@code networkerId}.
   * @return hashCode value
   */
  @Override
  public int hashCode() {
    int h = 31;
    h = h * 17 + networkerId.hashCode();
    return h;
  }

  /**
   * Prints the immutable value {@code GetSocialAccounts} with attribute values.
   * @return A string representation of the value
   */
  @Override
  public String toString() {
    return "GetSocialAccounts{"
        + "networkerId=" + networkerId
        + "}";
  }

  /**
   * Creates an immutable copy of a {@link GetSocialAccounts} value.
   * Uses accessors to get values to initialize the new immutable instance.
   * If an instance is already immutable, it is returned as is.
   * @param instance The instance to copy
   * @return A copied immutable GetSocialAccounts instance
   */
  public static ImmutableGetSocialAccounts copyOf(GetSocialAccounts instance) {
    if (instance instanceof ImmutableGetSocialAccounts) {
      return (ImmutableGetSocialAccounts) instance;
    }
    return ImmutableGetSocialAccounts.builder()
        .from(instance)
        .build();
  }

  /**
   * Creates a builder for {@link ImmutableGetSocialAccounts ImmutableGetSocialAccounts}.
   * @return A new ImmutableGetSocialAccounts builder
   */
  public static ImmutableGetSocialAccounts.Builder builder() {
    return new ImmutableGetSocialAccounts.Builder();
  }

  /**
   * Builds instances of type {@link ImmutableGetSocialAccounts ImmutableGetSocialAccounts}.
   * Initialize attributes and then invoke the {@link #build()} method to create an
   * immutable instance.
   * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
   * but instead used immediately to create instances.</em>
   */
  static final class Builder {
    private static final long INIT_BIT_NETWORKER_ID = 0x1L;
    private long initBits = 0x1L;

    private String networkerId;

    private Builder() {
    }

    /**
     * Fill a builder with attribute values from the provided {@code GetSocialAccounts} instance.
     * Regular attribute values will be replaced with those from the given instance.
     * Absent optional values will not replace present values.
     * @param instance The instance from which to copy values
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder from(GetSocialAccounts instance) {
      Objects.requireNonNull(instance, "instance");
      networkerId(instance.networkerId());
      return this;
    }

    /**
     * Initializes the value for the {@link GetSocialAccounts#networkerId() networkerId} attribute.
     * @param networkerId The value for networkerId 
     * @return {@code this} builder for use in a chained invocation
     */
    public final Builder networkerId(String networkerId) {
      this.networkerId = Objects.requireNonNull(networkerId, "networkerId");
      initBits &= ~INIT_BIT_NETWORKER_ID;
      return this;
    }

    /**
     * Builds a new {@link ImmutableGetSocialAccounts ImmutableGetSocialAccounts}.
     * @return An immutable instance of GetSocialAccounts
     * @throws java.lang.IllegalStateException if any required attributes are missing
     */
    public ImmutableGetSocialAccounts build() {
      if (initBits != 0) {
        throw new IllegalStateException(formatRequiredAttributesMessage());
      }
      return new ImmutableGetSocialAccounts(networkerId);
    }

    private String formatRequiredAttributesMessage() {
      List<String> attributes = new ArrayList<String>();
      if ((initBits & INIT_BIT_NETWORKER_ID) != 0) attributes.add("networkerId");
      return "Cannot build GetSocialAccounts, some of required attributes are not set " + attributes;
    }
  }

  /**
   * Immutable implementation of {@link GetSocialAccounts.R}.
   * <p>
   * Use the builder to create immutable instances:
   * {@code ImmutableGetSocialAccounts.R.builder()}.
   */
  public static final class R implements GetSocialAccounts.R {
    private final List<SocialAccount> socialAccounts;

    private R(List<SocialAccount> socialAccounts) {
      this.socialAccounts = socialAccounts;
    }

    /**
     * @return The value of the {@code socialAccounts} attribute
     */
    @Override
    public List<SocialAccount> socialAccounts() {
      return socialAccounts;
    }

    /**
     * Copy the current immutable object with elements that replace the content of {@link GetSocialAccounts.R#socialAccounts() socialAccounts}.
     * @param elements The elements to set
     * @return A modified copy of {@code this} object
     */
    public final ImmutableGetSocialAccounts.R withSocialAccounts(SocialAccount... elements) {
      List<SocialAccount> newValue = createUnmodifiableList(false, createSafeList(Arrays.asList(elements), true, false));
      return new ImmutableGetSocialAccounts.R(newValue);
    }

    /**
     * Copy the current immutable object with elements that replace the content of {@link GetSocialAccounts.R#socialAccounts() socialAccounts}.
     * A shallow reference equality check is used to prevent copying of the same value by returning {@code this}.
     * @param elements An iterable of socialAccounts elements to set
     * @return A modified copy of {@code this} object
     */
    public final ImmutableGetSocialAccounts.R withSocialAccounts(Iterable<? extends SocialAccount> elements) {
      if (this.socialAccounts == elements) return this;
      List<SocialAccount> newValue = createUnmodifiableList(false, createSafeList(elements, true, false));
      return new ImmutableGetSocialAccounts.R(newValue);
    }

    /**
     * This instance is equal to all instances of {@code R} that have equal attribute values.
     * @return {@code true} if {@code this} is equal to {@code another} instance
     */
    @Override
    public boolean equals(Object another) {
      if (this == another) return true;
      return another instanceof ImmutableGetSocialAccounts.R
          && equalTo((ImmutableGetSocialAccounts.R) another);
    }

    private boolean equalTo(ImmutableGetSocialAccounts.R another) {
      return socialAccounts.equals(another.socialAccounts);
    }

    /**
     * Computes a hash code from attributes: {@code socialAccounts}.
     * @return hashCode value
     */
    @Override
    public int hashCode() {
      int h = 31;
      h = h * 17 + socialAccounts.hashCode();
      return h;
    }

    /**
     * Prints the immutable value {@code R} with attribute values.
     * @return A string representation of the value
     */
    @Override
    public String toString() {
      return "R{"
          + "socialAccounts=" + socialAccounts
          + "}";
    }

    /**
     * Creates an immutable copy of a {@link GetSocialAccounts.R} value.
     * Uses accessors to get values to initialize the new immutable instance.
     * If an instance is already immutable, it is returned as is.
     * @param instance The instance to copy
     * @return A copied immutable R instance
     */
    public static ImmutableGetSocialAccounts.R copyOf(GetSocialAccounts.R instance) {
      if (instance instanceof ImmutableGetSocialAccounts.R) {
        return (ImmutableGetSocialAccounts.R) instance;
      }
      return ImmutableGetSocialAccounts.R.builder()
          .from(instance)
          .build();
    }

    /**
     * Creates a builder for {@link ImmutableGetSocialAccounts.R R}.
     * @return A new R builder
     */
    public static ImmutableGetSocialAccounts.R.Builder builder() {
      return new ImmutableGetSocialAccounts.R.Builder();
    }

    /**
     * Builds instances of type {@link ImmutableGetSocialAccounts.R R}.
     * Initialize attributes and then invoke the {@link #build()} method to create an
     * immutable instance.
     * <p><em>{@code Builder} is not thread-safe and generally should not be stored in a field or collection,
     * but instead used immediately to create instances.</em>
     */
    public static final class Builder {
      private List<SocialAccount> socialAccounts = new ArrayList<SocialAccount>();

      private Builder() {
      }

      /**
       * Fill a builder with attribute values from the provided {@code R} instance.
       * Regular attribute values will be replaced with those from the given instance.
       * Absent optional values will not replace present values.
       * Collection elements and entries will be added, not replaced.
       * @param instance The instance from which to copy values
       * @return {@code this} builder for use in a chained invocation
       */
      public final Builder from(GetSocialAccounts.R instance) {
        Objects.requireNonNull(instance, "instance");
        addAllSocialAccounts(instance.socialAccounts());
        return this;
      }

      /**
       * Adds one element to {@link GetSocialAccounts.R#socialAccounts() socialAccounts} list.
       * @param element A socialAccounts element
       * @return {@code this} builder for use in a chained invocation
       */
      public final Builder addSocialAccounts(SocialAccount element) {
        this.socialAccounts.add(Objects.requireNonNull(element, "socialAccounts element"));
        return this;
      }

      /**
       * Adds elements to {@link GetSocialAccounts.R#socialAccounts() socialAccounts} list.
       * @param elements An array of socialAccounts elements
       * @return {@code this} builder for use in a chained invocation
       */
      public final Builder addSocialAccounts(SocialAccount... elements) {
        for (SocialAccount element : elements) {
          this.socialAccounts.add(Objects.requireNonNull(element, "socialAccounts element"));
        }
        return this;
      }

      /**
       * Sets or replaces all elements for {@link GetSocialAccounts.R#socialAccounts() socialAccounts} list.
       * @param elements An iterable of socialAccounts elements
       * @return {@code this} builder for use in a chained invocation
       */
      public final Builder socialAccounts(Iterable<? extends SocialAccount> elements) {
        this.socialAccounts.clear();
        return addAllSocialAccounts(elements);
      }

      /**
       * Adds elements to {@link GetSocialAccounts.R#socialAccounts() socialAccounts} list.
       * @param elements An iterable of socialAccounts elements
       * @return {@code this} builder for use in a chained invocation
       */
      public final Builder addAllSocialAccounts(Iterable<? extends SocialAccount> elements) {
        for (SocialAccount element : elements) {
          this.socialAccounts.add(Objects.requireNonNull(element, "socialAccounts element"));
        }
        return this;
      }

      /**
       * Builds a new {@link ImmutableGetSocialAccounts.R R}.
       * @return An immutable instance of R
       * @throws java.lang.IllegalStateException if any required attributes are missing
       */
      public ImmutableGetSocialAccounts.R build() {
        return new ImmutableGetSocialAccounts.R(createUnmodifiableList(true, socialAccounts));
      }
    }
  }

  private static <T> List<T> createSafeList(Iterable<? extends T> iterable, boolean checkNulls, boolean skipNulls) {
    ArrayList<T> list;
    if (iterable instanceof Collection<?>) {
      int size = ((Collection<?>) iterable).size();
      if (size == 0) return Collections.emptyList();
      list = new ArrayList<T>();
    } else {
      list = new ArrayList<T>();
    }
    for (T element : iterable) {
      if (skipNulls && element == null) continue;
      if (checkNulls) Objects.requireNonNull(element, "element");
      list.add(element);
    }
    return list;
  }

  private static <T> List<T> createUnmodifiableList(boolean clone, List<T> list) {
    switch(list.size()) {
    case 0: return Collections.emptyList();
    case 1: return Collections.singletonList(list.get(0));
    default:
      if (clone) {
        return Collections.unmodifiableList(new ArrayList<T>(list));
      } else {
        if (list instanceof ArrayList<?>) {
          ((ArrayList<?>) list).trimToSize();
        }
        return Collections.unmodifiableList(list);
      }
    }
  }
}
